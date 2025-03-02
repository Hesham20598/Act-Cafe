package com.otherlogic.domain.usecases.menu

import com.otherlogic.domain.entity.menu.MenuResponseDto
import com.otherlogic.domain.repositories.menu.MenuRepository
import javax.inject.Inject

class GetMenuUseCase @Inject constructor(
    private val menuRepository: MenuRepository
) {
    suspend operator fun invoke(): MenuResponseDto = try {
        menuRepository.getMenu()
    } catch (e: Exception) {
        throw e
    }
}