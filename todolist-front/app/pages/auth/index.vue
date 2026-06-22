<template>
<div class="bg-light">
        <div class="mx-auto login-container">
            <div class="card card-body rounded-4 shadow-sm border-light" >
                <div class="mb-5 border-bottom w-100">
                    <div class="d-flex gap-3 py-5 align-items-center justify-content-center">
                        <button class="btn btn-outline-secondary btn-box">
                            <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" viewBox="0 0 640 640"><!-- Icon from Font Awesome Brands by Dave Gandy - https://creativecommons.org/licenses/by/4.0/ --><path fill="currentColor" d="M564 325.8C564 467.3 467.1 568 324 568C186.8 568 76 457.2 76 320S186.8 72 324 72c66.8 0 123 24.5 166.3 64.9l-67.5 64.9c-88.3-85.2-252.5-21.2-252.5 118.2c0 86.5 69.1 156.6 153.7 156.6c98.2 0 135-70.4 140.8-106.9H324v-85.3h236.1c2.3 12.7 3.9 24.9 3.9 41.4"/></svg>
                        </button>
                        <button class="btn btn-outline-secondary btn-box">
                            <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" viewBox="0 0 640 640"><!-- Icon from Font Awesome Brands by Dave Gandy - https://creativecommons.org/licenses/by/4.0/ --><path fill="currentColor" d="M568 320c0 137-111 248-248 248c-25.6 0-50.2-3.9-73.4-11.1c10.1-16.5 25.2-43.5 30.8-65c3-11.6 15.4-59 15.4-59c8.1 15.4 31.7 28.5 56.8 28.5c74.8 0 128.7-68.8 128.7-154.3c0-81.9-66.9-143.2-152.9-143.2c-107 0-163.9 71.8-163.9 150.1c0 36.4 19.4 81.7 50.3 96.1c4.7 2.2 7.2 1.2 8.3-3.3c.8-3.4 5-20.3 6.9-28.1c.6-2.5.3-4.7-1.7-7.1c-10.1-12.5-18.3-35.3-18.3-56.6c0-54.7 41.4-107.6 112-107.6c60.9 0 103.6 41.5 103.6 100.9c0 67.1-33.9 113.6-78 113.6c-24.3 0-42.6-20.1-36.7-44.8c7-29.5 20.5-61.3 20.5-82.6c0-19-10.2-34.9-31.4-34.9c-24.9 0-44.9 25.7-44.9 60.2c0 22 7.4 36.8 7.4 36.8s-24.5 103.8-29 123.2c-5 21.4-3 51.6-.9 71.2C137.4 514.9 72 425.1 72 320C72 183 183 72 320 72s248 111 248 248"/></svg>
                        </button>
                        <button class="btn btn-outline-secondary btn-box">
                            <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" viewBox="0 0 640 640"><!-- Icon from Font Awesome Brands by Dave Gandy - https://creativecommons.org/licenses/by/4.0/ --><path fill="currentColor" d="M453.2 112h70.6L369.6 288.2L551 528H409L297.7 382.6L170.5 528H99.8l164.9-188.5L90.8 112h145.6l100.5 132.9zm-24.8 373.8h39.1L215.1 152h-42z"/></svg>
                        </button>
                    </div>
                </div>
                <form>
                    <div class="form-floating mb-3">
                        <input type="email" class="form-control form-control-sm" id="userEmail" placeholder="Email">
                        <label for="userEmail">E-mail</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="password" class="form-control form-control-sm" id="userPassword" placeholder="Password">
                        <label for="userPassword">Password</label>
                    </div>
                </form>
                <div class="d-flex flex-column gap-1">
                    <button type="submit" class="btn btn-primary d-block w-100">Login</button>
                    <button type="submit" class="btn btn-link text-decoration-none d-block w-100">Cadastrar</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
    definePageMeta({
        layout: 'login',
        title: 'Login'
    })
</script>

<style>

</style>