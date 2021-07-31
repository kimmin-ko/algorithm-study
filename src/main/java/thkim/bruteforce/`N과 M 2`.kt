package thkim.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(M)

    fun recursion(pivot: Int = 1, depth: Int = 0) {
        if (depth == M) {
            arr.forEach { print("$it ") }
            println()
            return
        }

        for (i in pivot..N) {
            arr[depth] = i
            recursion(i + 1, depth + 1)
        }
    }

    recursion()
}