package com.example.pruebatecnicasebastianpedraza.data.model

data class Project(
    val project_name: String = "",
    val operating_cost: Double = 0.0,
    val annual_turnover: Double = 0.0,
    val number_of_operators: Int = 0,
    val amount_of_energy: Double = 0.0,
    val budget_execution_level: Double = 0.0,
    var color_background : String = ""

)
