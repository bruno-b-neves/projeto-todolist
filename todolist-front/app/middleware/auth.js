// middleware/auth.ts

export default defineNuxtRouteMiddleware((to, from) => {
  // A store TEM que ser instanciada AQUI DENTRO, nunca fora!
  const authStore = useAuthStore() 

// REGRA 1: Se NÃO está logado e tenta acessar uma página protegida -> vai para o Login
  if (!authStore.isLogged && to.path !== '/login' && to.path !== '/') {
    return navigateTo('/login')
  }

  // REGRA 2 (A que está faltando): Se JÁ está logado e tenta ir para o Login ou para a Raiz -> vai para o Dashboard
  if (authStore.isLogged && to.path === '/login' || to.path === '/') {
    return navigateTo('/dashboard')
  }
})