package com.example.homework_5


object MockProvider {
    fun getMockPost() = listOf(
        Post(
             1,
            "Card with content",
            "Content description",
            "Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line. Some very long text that probably w...",
            "https://images.unsplash.com/photo-1442689859438-97407280183f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1770&q=80",
        ),
        Post(
             2,
             "Card with content",
            "Content description",
            "Some text here...",
            null
        ),
        Post(
             3,
            "Card with content",
            "Content description",
            null,
            "https://unsplash.com/photos/-ZSnI9gSX1Y/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MTV8fGR1Y2t8ZW58MHx8fHwxNjUxODExMTY2&force=true",
        ),
        Post(
            4,
            "Card with content",
            "Content description",
            "Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line.",
            "https://images.unsplash.com/photo-1620573083867-730048a6cb33?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=3431&q=80",
        ),
        Post(
            5,
            "Card with content",
            "Content description",
            null,
            "https://images.unsplash.com/photo-1506109761143-06e7aa89a8a9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1771&q=80",
        ),
        Post(
             6,
            "Card with content",
            "Content description",
            "Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line.",
            null
        ),
    )
}