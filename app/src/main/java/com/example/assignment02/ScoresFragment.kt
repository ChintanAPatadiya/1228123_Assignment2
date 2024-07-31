package com.example.assignment02

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class ScoresFragment : DialogFragment() {

    private lateinit var scoreTextView: TextView
    private lateinit var totalQuestionsTextView: TextView
    private lateinit var correctAnswersTextView: TextView

    companion object {
        fun newInstance(score: Int, totalQuestions: Int, correctAnswers: Int): ScoresFragment {
            val fragment = ScoresFragment()
            val args = Bundle().apply {
                putInt("score", score)
                putInt("totalQuestions", totalQuestions)
                putInt("correctAnswers", correctAnswers)
            }
            fragment.arguments = args
            return fragment
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_scores, container, false)

        // Initialize views
        scoreTextView = view.findViewById(R.id.score)
        totalQuestionsTextView = view.findViewById(R.id.total_questions)
        correctAnswersTextView = view.findViewById(R.id.correct_answers)

        // Safely get arguments
        val score = arguments?.getInt("score") ?: 0
        val totalQuestions = arguments?.getInt("totalQuestions") ?: 0
        val correctAnswers = arguments?.getInt("correctAnswers") ?: 0

        // Update UI with arguments
        scoreTextView.text = "Score: $score/$totalQuestions (${correctAnswers} correct answers)"
        totalQuestionsTextView.text = "Total Questions: $totalQuestions"
        correctAnswersTextView.text = "Correct Answers: $correctAnswers"

        return view
    }
}
