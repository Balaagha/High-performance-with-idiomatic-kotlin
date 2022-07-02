package com.example.androidimpltemplate.kotlin


class Book(val title: String, val author: String) {
    // impure function
    fun getBookDetails() = "$title - $author"
}


fun main() {
    // pure function
    fun getBookDetails(title: String, author: String) = "$title - $author"

    fun titleStartsWithS(book: Book) = book.title.startsWith("S")
    fun lengthOfTitleGraterThan5(book: Book) = book.title.length > 5
    fun authorStartsWithB(book: Book) = book.author.startsWith("B")

    val book1 = Book("Start with why", "Simon Sinek")
    val book2 = Book("Dare to lead", "Brene Brown")
    val book3 = Book("Start with why", "Brene Brown")
    val books = listOf(book1, book2, book3)

// this code should be improved
    val filteredBooks = books
        .filter(::titleStartsWithS)
        .filter(::authorStartsWithB)
        .filter(::lengthOfTitleGraterThan5)

    println("filteredBooks => $filteredBooks")


// 1st solution = dedicated predicat
    fun allFilters(book: Book): Boolean = titleStartsWithS(book)
            && lengthOfTitleGraterThan5(book)
            && authorStartsWithB(book)

    val filteredBooksSolutionOne = books
        .filter(::allFilters)

    println("filteredBooksSolutionOne => $filteredBooksSolutionOne")


// 2nd solution = anonymous function
    val filteredBooksSolutionTwo = books.filter(
        fun(book: Book) = titleStartsWithS(book) && lengthOfTitleGraterThan5(book) && authorStartsWithB(book)
    )

    println("filteredBooksSolutionTwo => $filteredBooksSolutionTwo")


// 3rd solution = function composition
    val filteredBooksSolutionThree =books.filter(
        ::titleStartsWithS
                and ::authorStartsWithB
                and ::lengthOfTitleGraterThan5
    )

    println("filteredBooksSolutionThree => $filteredBooksSolutionThree")


}


// 3rd solution = function composition
inline infix fun <T> ((T) -> Boolean).and(crossinline predicate: (T) -> Boolean): (T) -> Boolean {
    return { t: T -> this(t) && predicate(t) }
}