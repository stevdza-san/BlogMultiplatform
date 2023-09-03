#-----------------------------------------------------------------------------
# Variables shared across multiple stages (they need to be explicitly opted
# into each stage by being declaring there too, but their values need only be
# specified once).
ARG KOBWEB_APP_ROOT="site"

#-----------------------------------------------------------------------------
# Create an intermediate stage which builds and exports our site. In the
# final stage, we'll only extract what we need from this stage, saving a lot
# of space.
FROM amazoncorretto:17 as export

ENV KOBWEB_CLI_VERSION=0.9.13
ARG KOBWEB_APP_ROOT

# Copy the project code to an arbitrary subdir so we can install stuff in the
# Docker container root without worrying about clobbering project files.
COPY . /project

# Update and install required OS packages to continue
# Note: Playwright is a system for running browsers, and here we use it to
# install Chromium.
RUN apt-get update \
    && apt-get install -y curl gnupg unzip wget \
    && curl -sL https://deb.nodesource.com/setup_19.x | bash - \
    && apt-get install -y nodejs \
    && npm init -y \
    && npx playwright install --with-deps chromium

# Fetch the latest version of the Kobweb CLI
RUN wget https://github.com/varabyte/kobweb-cli/releases/download/v${KOBWEB_CLI_VERSION}/kobweb-${KOBWEB_CLI_VERSION}.zip \
    && unzip kobweb-${KOBWEB_CLI_VERSION}.zip \
    && rm kobweb-${KOBWEB_CLI_VERSION}.zip

ENV PATH="/kobweb-${KOBWEB_CLI_VERSION}/bin:${PATH}"

WORKDIR /project/${KOBWEB_APP_ROOT}

# Decrease Gradle memory usage to avoid OOM situations in tight environments
# (many free Cloud tiers only give you 512M of RAM). The following amount
# should be more than enough to build and export our site.
RUN mkdir ~/.gradle && \
    echo "org.gradle.jvmargs=-Xmx256m" >> ~/.gradle/gradle.properties

RUN kobweb export --notty

#-----------------------------------------------------------------------------
# Create the final stage, which contains just enough bits to run the Kobweb
# server.
FROM amazoncorretto:17-alpine-jdk as run

ARG KOBWEB_APP_ROOT

COPY --from=export /project/${KOBWEB_APP_ROOT}/.kobweb .kobweb

ENTRYPOINT .kobweb/server/start.sh
