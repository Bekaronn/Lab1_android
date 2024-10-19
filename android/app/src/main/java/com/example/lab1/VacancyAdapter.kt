package com.example.lab1

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VacancyAdapter(
    private var vacancies: List<Vacancy>,
    private val onItemClick: (Vacancy) -> Unit
) : RecyclerView.Adapter<VacancyAdapter.VacancyViewHolder>() {

    inner class VacancyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.vacancy_title)
        private val companyTextView: TextView = itemView.findViewById(R.id.vacancy_company)
        private val salaryTextView: TextView = itemView.findViewById(R.id.vacancy_salary)
        private val locationTextView: TextView = itemView.findViewById(R.id.vacancy_location)

        fun bind(vacancy: Vacancy) {
            titleTextView.text = vacancy.title
            companyTextView.text = vacancy.company
            salaryTextView.text = vacancy.salary
            locationTextView.text = vacancy.location

            itemView.setOnClickListener { onItemClick(vacancy) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacancyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.vacancy_list_item, parent, false)
        return VacancyViewHolder(view)
    }

    override fun onBindViewHolder(holder: VacancyViewHolder, position: Int) {
        holder.bind(vacancies[position])
    }

    override fun getItemCount(): Int = vacancies.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newVacancies: List<Vacancy>) {
        vacancies = newVacancies
        notifyDataSetChanged()
    }
}
