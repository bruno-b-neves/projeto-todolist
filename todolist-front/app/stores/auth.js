import { defineStore } from 'pinia'
import { ref, computed } from 'vue'

export const useAuthStore = defineStore('auth', () => {
  const userId = useCookie('user_id', { default: () => null })
  const userName = useCookie('user_name', { default: () => '' })
  
  // Retorna true se houver um ID salvo, ou seja, se o cara logou
  const isLogged = computed(() => !!userId.value)

  function setUser(user) {
    userId.value = user.id
    userName.value = user.name
  }

  function clearUser() {
    userId.value = null
    userName.value = ''
  }

  return { userId, userName, isLogged, setUser, clearUser }
})