package com.example.labo7_pdm_00046317

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.labo7_pdm_00046317.Database.GithubRepo
import com.example.labo7_pdm_00046317.ViewModels.GitHubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(GitHubRepoViewModel::class.java)

        Add.setOnClickListener {
            val name = textView.text.toString()
            if (name.isNotEmpty() && name.isNotBlank()){
                viewModel.insert(GithubRepo(name = name))
            }
        }

        viewModel.getAll().observe(this, Observer {repos ->
            Log.d("Lista de repos", "___________________________________________________________")
            for (repo in repos){
                Log.d("Repo "+repo.id, repo.name)
            }

        })

    }
}
