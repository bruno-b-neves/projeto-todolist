<template>
<div class="bg-light login-page">
    <div class="container">
        <div class="mx-auto login-container">
            <div class="card card-body rounded-4 shadow-sm border-light" >
                <AuthLoginSociais></AuthLoginSociais>
                <AuthFormLogin></AuthFormLogin>
                
            </div>
        </div>
    </div>
</div>
</template>

<script setup>
    definePageMeta({
        layout: 'login',
        title: 'Login',
        middleware: 'auth'
    })
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

    .btn-box {
        width: 42px;
        height: 42px;
        display: flex;
        align-items: center;
        justify-content: center;
    }
</style>