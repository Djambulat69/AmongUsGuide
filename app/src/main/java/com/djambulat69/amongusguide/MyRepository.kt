package com.djambulat69.amongusguide

object MyRepository {
    val crewmateTips = listOf<AmongUsTip>(
            AmongUsTip(R.string.how_to_play_title, R.string.crewmate_how_to_play_text,
                R.drawable.how_to_play_crewmate_image
            ),
            AmongUsTip(R.string.tips_and_tricks_title, R.string.crewmate_tips_and_tricks_text,
                R.drawable.visual_task_image
            ),
            AmongUsTip(R.string.best_settings_title, R.string.best_settings_text,
                R.drawable.best_settings_image
            ),
            AmongUsTip(R.string.settings_tutorial_title, R.string.settings_tutorial_text,
                R.drawable.settings_tutorial_image
            ),
            AmongUsTip(R.string.the_skeld_tasks_guide_title, R.string.the_skeld_tasks_guide_text,
                R.drawable.the_skeld_tasks_guide_image
            ),
            AmongUsTip(R.string.mirahq_tasks_guide_title, R.string.mirahq_tasks_guide_text,
                R.drawable.mirahq_tasks_guide_image
            )
    )
    val impostorTips = listOf<AmongUsTip>(
            AmongUsTip(R.string.how_to_play_title,
                R.string.impostor_how_to_play_text,
                R.drawable.how_to_play_impostor_image
            ),
            AmongUsTip(R.string.tips_and_tricks_title,
                R.string.impostor_tips_and_tricks_text,
                R.drawable.among_us_dummy_image),
            AmongUsTip(R.string.the_skeld_sabotages_vents_title,
                R.string.the_skeld_sabotages_vents_text,
                R.drawable.the_skeld_sabotages_vents_image
            ),
            AmongUsTip(R.string.mirahq_sabotages_vents_title, R.string.mirahq_sabotages_vents_text,
                R.drawable.mirahq_sabotage_vents_image
            )
    )
}