package com.example.assignment02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import androidx.fragment.app.DialogFragment

class QuizFragment : DialogFragment() {

    private lateinit var questionTextView: TextView
    private lateinit var answerEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var errorMessageTextView: TextView
    private lateinit var scoreTextView: TextView

    private val questions = arrayOf(
        "What is the capital of France?",
        "Who is the CEO of SpaceX?",
        "What is the largest planet in our solar system?"
    )

    private val answers = arrayOf(
        "Paris",
        "Elon Musk",
        "Jupiter"
    )

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_quiz, container, false)

        questionTextView = view.findViewById(R.id.question)
        answerEditText = view.findViewById(R.id.answer)
        submitButton = view.findViewById(R.id.submit)
        errorMessageTextView = view.findViewById(R.id.error_message)
        scoreTextView = view.findViewById(R.id.score)

        questionTextView.text = questions[currentQuestionIndex]

        submitButton.setOnClickListener {
            val userAnswer = answerEditText.text.toString()
            if (userAnswer.equals(answers[currentQuestionIndex], true)) {
                score++
                errorMessageTextView.text = "Correct!"
            } else {
                errorMessageTextView.text = "Incorrect. The correct answer is ${answers[currentQuestionIndex]}"
            }

            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                questionTextView.text = questions[currentQuestionIndex]
                answerEditText.text.clear()
            } else {
                scoreTextView.text = "Your final score is $score/${questions.size}"
                submitButton.isEnabled = false
            }
        }

        return view
    }
}