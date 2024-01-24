/**
 * mode 0 or 1
 * 문자열에 내에 1이있으면 mode를 바꿈
 *
 * mode 0
 * - code[idx] != 1
 *      - idx가 짝수일때 ret 의 맨뒤에 code[idx]를 추가
 * mode 1
 * - code[idx] == 1
 *      - idx가 홀수일때 ret 의 맨뒤에 code[idx]를 추가
 */

class Solution {
    companion object {
        const val MODE_1 = '1'
        const val MODE_0 = '0'
    }

    fun solution(code: String): String {
        var answer: String = ""
        var stringBuilder = StringBuilder()
        var mode = MODE_0

        for (idx in code.indices) {
            //코드가 1,0 인지 확인
            when (code[idx]) {
                '1' -> if (mode == MODE_1) mode = MODE_0
                else if (mode == MODE_0) mode = MODE_1

                else -> {
                    //코드가 문자 이면, 해당 모드에따라 처리
                    if (mode == MODE_0) {
                        if (idx % 2 == 0) stringBuilder.append(code[idx])
                    } else if (mode == MODE_1) {
                        if (idx % 2 == 1) stringBuilder.append(code[idx])
                    }

                }
            }
            answer = stringBuilder.toString()
        }
        return answer.ifBlank { "EMPTY" }
    }
}

fun main() {
    println( Solution().solution("abc1abc1abc"))//acbac
}