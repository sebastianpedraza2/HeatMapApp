package com.example.pruebatecnicasebastianpedraza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

                          // ARCHITECTURE: (MVVM)

//    ┏━━━━━━━━┓     ┏━━━━━━━━━━━━━━┓     ┏━━━━━━━━━━━━━━┓     ┏━━━━━━━━━━┓
//    ┃   UI   ┃---> ┃ presentation ┃---> ┃  repository  ┃---> ┃   data   ┃
//    ┗━━━━━━━━┛     ┗━━━━━━━━━━━━━━┛     ┗━━━━━━━━━━━━━━┛     ┗━━━━━━━━━━┛
//


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
// HomeScreenFragment is the NavHostFragment, for more info go to the main_graph navigation resource file