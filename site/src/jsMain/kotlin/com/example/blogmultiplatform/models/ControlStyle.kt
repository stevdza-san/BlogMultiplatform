package com.example.blogmultiplatform.models

sealed class ControlStyle(val style: String) {
    data class Bold(val selectedText: String?) : ControlStyle(
        style = "<strong>$selectedText</strong>"
    )

    data class Italic(val selectedText: String?) : ControlStyle(
        style = "<em>$selectedText</em>"
    )

    data class Link(
        val selectedText: String?,
        val href: String,
        val title: String
    ) : ControlStyle(
        style = "<a href=\"$href\" title=\"$title\">$selectedText</a>"
    )

    data class Title(val selectedText: String?) : ControlStyle(
        style = "<strong><h1>$selectedText</h1></strong>"
    )

    data class Subtitle(val selectedText: String?) : ControlStyle(
        style = "<strong><h3>$selectedText</h3></strong>"
    )

    data class Quote(val selectedText: String?) : ControlStyle(
        style = "<div style=\"background-color:#FAFAFA;padding:12px;border-radius:6px;\"><em>❞ $selectedText</em></div>"
    )

    data class Code(val selectedText: String?) : ControlStyle(
        style = "<div style=\"background-color:#0d1117;padding:12px;border-radius:6px;\"><pre><code class=\"language-kotlin\"> $selectedText </code></pre></div>"
    )

    data class Image(
        val selectedText: String?,
        val imageLink: String,
        val desc: String
    ) : ControlStyle(
        style = "<img src=\"$imageLink\" alt=\"$desc\" style=\"max-width: 100%\">$selectedText</img>"
    )
}
