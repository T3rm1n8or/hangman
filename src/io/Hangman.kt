package io

fun main (args:Array<String>) {
  println("Pick a word for your opponent to start the game:")
  val word = readLine()
  if (word == null) {
    println("You entered nothing for your opponent. Game over.")
    return

  }

  //hide word
  for (i in 1..100) {
    println()
  }

  //storing the word
  //eg. if the word is Tree
  // Normalise .toLowercase makes the letters lowercase the .toCharArray keeps them in order ['s', 'a', 'l' 'a', 'd' ]
  // .toHashset for duplication {'s','a','l','d'}
  val letters = word.toLowerCase().toCharArray().toHashSet()  //See comment notes above
  val correctGuesses = mutableSetOf<Char>()
  var fails = 0

  while (letters != correctGuesses) {
 printExploredWord(word, correctGuesses)
    println("#Wrong guesses: $fails\n\n")
    print("Guess a letter in your opponent's word: ")
    val input = readLine()

    if (input == null) {
      continue
    } else if (input.length != 1) {
      println("Enter 1 letter")
      continue
    }
    if (word.toLowerCase().contains(input.toLowerCase())) {
      correctGuesses.add(input[0].toLowerCase()) // 0 gets the first character of string

    } else {
      fails++ //++ increases variable by one
    }
  }
  printExploredWord(word, correctGuesses)
  println("\n#Wrong guesses: $fails\n\n")
  println("Congratulations, you guessed your opponent's word. Players with the least number of wrong guesses win.")



}


fun printExploredWord (word: String, correctGuesses: Set<Char>) {
  for (character in word.toLowerCase()){
    if (correctGuesses.contains(character)){
      print(character + " ")

    } else {
      print("_ ")
    }
  }
}
