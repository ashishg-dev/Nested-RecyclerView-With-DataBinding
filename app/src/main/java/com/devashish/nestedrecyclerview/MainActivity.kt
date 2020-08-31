package com.devashish.nestedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.devashish.nestedrecyclerview.adapter.TeamAdapter
import com.devashish.nestedrecyclerview.databinding.ActivityMainBinding
import com.devashish.nestedrecyclerview.enums.PlayerType
import com.devashish.nestedrecyclerview.model.PlayersModel
import com.devashish.nestedrecyclerview.model.TeamModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var teamAdapter: TeamAdapter
    private var teams = ArrayList<TeamModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.lifecycleOwner = this

        setAdapter()

        addCSKWithPlayers()
        addRCBWithPlayers()
        teamAdapter.notifyDataSetChanged()

    }

    private fun setAdapter() {

        teamAdapter = TeamAdapter(teams)
        val layoutManager = LinearLayoutManager(this)
        recyclerViewTeam.layoutManager = layoutManager
        recyclerViewTeam.adapter = teamAdapter

    }

    private fun addCSKWithPlayers() {

        val playersDhoni = PlayersModel("Dhoni", PlayerType.WICKET_KEEPER, true)
        val playersRaina = PlayersModel("Raina", PlayerType.BATMAN, false)
        val playersBravo = PlayersModel("Bravo", PlayerType.ALL_ROUNDER, false)
        val playersAshwin = PlayersModel("Ashwin", PlayerType.BOWLER, false)

        val players = ArrayList<PlayersModel>()
        players.add(playersDhoni)
        players.add(playersRaina)
        players.add(playersBravo)
        players.add(playersAshwin)

        teams.add(TeamModel("CSK", players))

    }

    private fun addRCBWithPlayers() {

        val playersKholi = PlayersModel("Kholi", PlayerType.BATMAN, true)
        val playersGayle = PlayersModel("Gayle", PlayerType.BATMAN, false)
        val playersAB = PlayersModel("ab de villiers", PlayerType.BATMAN, false)
        val playersStarch = PlayersModel("Starch", PlayerType.BOWLER, false)

        val players = ArrayList<PlayersModel>()
        players.add(playersKholi)
        players.add(playersGayle)
        players.add(playersAB)
        players.add(playersStarch)

        teams.add(TeamModel("RCB", players))

    }
}