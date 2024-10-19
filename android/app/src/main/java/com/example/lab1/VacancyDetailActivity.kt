package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.lab1.databinding.ActivityVacancyDetailBinding

class VacancyDetailActivity : ComponentActivity() {
    private lateinit var binding: ActivityVacancyDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVacancyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vacancy = intent.getSerializableExtra("vacancy") as? Vacancy

        vacancy?.let {
            binding.vacancyDetailTitle.text = it.title
            binding.vacancyDetailCompany.text = it.company
            binding.vacancyDetailSalary.text = it.salary
            binding.vacancyDetailLocation.text = it.location
            binding.vacancyDetailDescription.text = it.description
            binding.vacancyDetailRequirements.text = it.requirements
            binding.vacancyDetailApplication.text = it.applicationInstructions
        }
    }
}
