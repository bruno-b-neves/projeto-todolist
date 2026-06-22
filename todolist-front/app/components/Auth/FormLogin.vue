<template>
  <div>
    <form @submit.prevent="onLogin">
        <div class="form-floating mb-3">
            <input type="email" class="form-control form-control-sm" id="userEmail" placeholder="Email" v-model="form.email">
            <label for="userEmail">E-mail</label>
        </div>
        <div class="form-floating mb-3">
            <input type="password" class="form-control form-control-sm" id="userPassword" placeholder="Password" v-model="form.password" suggest="current-password">
            <label for="userPassword">Password</label>
        </div>
        <div class="d-flex flex-column gap-1">
            <button type="submit" class="btn btn-primary d-block w-100" :disabled="isLoading">
                {{ isLoading ? 'Entrando...' : 'Login' }}
            </button>
            <!-- <button type="submit" class="btn btn-link text-decoration-none d-block w-100">Cadastrar</button> -->
        </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const authStore = useAuthStore();
const router = useRouter();

const form = ref({
    email: '',
    password: ''
});

const loginError = ref('');
const isLoading = ref(false);

const onLogin = async () => {
    loginError.value = '';
    isLoading.value = true;

try {
    const response = await fetch('http://localhost:8080/users/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(form.value) // Envia o email e password direto
    })

    if (!response.ok) {
      throw new Error('E-mail ou senha incorretos.')
    }

    const userData = await response.json() // Recebe { id, name, token } do Spring Boot
    console.log('Login bem-sucedido:', userData) // Verifique o que está sendo retornado
    
    // Salva o usuário logado no Pinia
    authStore.setUser(userData)

    // Manda o usuário para a tela protegida
    router.push('/dashboard')

  } catch (error) {
    loginError.value = error.message
  } finally {
    isLoading.value = false
  }
}


</script>

<style lang="scss" scoped>
    .login-container {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100%;
        width: 450px
    }

    .login-page {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100vh;
    }
</style>