package com.example.android.courtcounter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Constants for valid scores
    public static final int TOUCH_DOWN = 6;
    public static final int FIELD_GOAL = 3;
    public static final int SAFETY = 2;
    public static final int EXTRA_POINT = 1;

    private int[] points = {0, 0};  // Tracks the points won by each Team
    TextView scoreViewA;
    TextView scoreViewB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get references to score views
        scoreViewA = findViewById(R.id.team_a_score);
        scoreViewB = findViewById(R.id.team_b_score);
        // Initial display
        displayForTeam(points, 0);
        displayForTeam(points, 1);
    }

    /**
     * Adds 6 points to either Team
     */
    public void sixPointsForTeam(View view) {
        int viewId = view.getId();
        addScores(viewId, TOUCH_DOWN);
    }

    /**
     * Adds 3 points to either Team
     */
    public void threePointsForTeam(View view) {
        int viewId = view.getId();
        addScores(viewId, FIELD_GOAL);
    }

    /**
     * Adds 2 points to either Team
     */
    public void twoPointsForTeam(View view) {
        int viewId = view.getId();
        addScores(viewId, SAFETY);
    }

    /**
     * Adds 1 point to either Team
     */
    public void onePointForTeam(View view) {
        int viewId = view.getId();
        addScores(viewId, EXTRA_POINT);
    }

    /**
     * Adds the score and displays the updated score
     */
    public void addScores(int viewId, int score) {
        if (viewId == R.id.six_points_for_a || viewId == R.id.three_points_for_a || viewId == R.id.two_points_for_a || viewId == R.id.one_point_for_a) {
            points[0] += score;
            displayForTeam(points, 0);
        } else {
            points[1] += score;
            displayForTeam(points, 1);
        }
    }

    /**
     * Resets and displays score for both teams
     */
    public void resetScores(View view) {
        points[0] = 0;
        points[1] = 0;
        displayForTeam(points, 0);
        displayForTeam(points, 1);
    }

    /**
     * Displays the given score for either Team.
     */
    public void displayForTeam(int[] score, int team) {
        if (team == 0) {
            scoreViewA.setText(String.valueOf(score[team]));
        } else {
            scoreViewB.setText(String.valueOf(score[team]));
        }
    }
}
