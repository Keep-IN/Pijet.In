package com.example.pijetin.data.model

object DataSpotlight {
    val spotlightList = mutableListOf(
        SpotlightItemModel("data:image/jpeg;base64,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"),
        SpotlightItemModel("data:image/jpeg;base64,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"),
        SpotlightItemModel("data:image/jpeg;base64,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")
    )
}