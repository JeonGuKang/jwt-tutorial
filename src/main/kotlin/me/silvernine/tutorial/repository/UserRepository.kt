package me.silvernine.tutorial.repository

import me.silvernine.tutorial.entity.User
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User?, Long?> {

    /**
     * EntityGraph 은 쿼리가 수행이 될때 lazy 조회가 아니고 eager 조회로 authorities 정보를 같이 가져옴
     */
    @EntityGraph(attributePaths = ["authorities"])
    fun findOneWithAuthoritiesByUsername(username: String): Optional<User>
}