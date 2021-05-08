package me.zepeto.creator.in_app_game.creator.command.config

import com.p6spy.engine.spy.appender.MessageFormattingStrategy

class P6SpyZepetoLineFormat: MessageFormattingStrategy {
    override fun formatMessage(
        connectionId: Int,
        now: String?,
        elapsed: Long,
        category: String?,
        prepared: String?,
        sql: String?,
        url: String?
    ): String {
        return """#$now | took ${elapsed}ms | $category | connection $connectionId| url $url
$sql;"""
    }
}
