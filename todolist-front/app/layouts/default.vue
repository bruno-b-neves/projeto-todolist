<template>
    <div>
        <header class="navbar sticky-top bg-dark flex-md-wrap p-0 shadow py-2" data-bs-theme="dark">
            <div class="container">
                <a class="navbar-brand col-md-3 col-lg-2 me-0 fs-3 text-white mb-0" href="#">Lista de Tarefas</a>
                <ul class="navbar-nav flex-row align-items-center">
                    <li class="nav-item">
                        <div id="navbarSearch" class="navbar-search w-100 px-2 bg-dark-subtle border-dark-subtle collapse">
                            <input class="form-control w-100" type="text" placeholder="Search" aria-label="Search">
                        </div>
                    </li>
                    <li class="nav-item text-nowrap">
                        <button class="nav-link text-white" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSearch" aria-controls="navbarSearch" aria-expanded="false" aria-label="Toggle search"> 
                            <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 24 24"><!-- Icon from Myna UI Icons by Praveen Juge - https://github.com/praveenjuge/mynaui-icons/blob/main/LICENSE --><path fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="1.5" d="M19 11.5a7.5 7.5 0 1 1-15 0a7.5 7.5 0 0 1 15 0m-2.107 5.42l3.08 3.08"/></svg>
                        </button>
                    </li>
                    
                </ul>
            </div>
        </header>
        <main class="py-4 main">
            <div class="container">
                <slot></slot>
            </div>
        </main>
        <footer class="px-md-4 py-3 border-top text-center bg-body-tertiary">
            <p class="mb-0">&copy; 2024 My Todo List App</p>
        </footer>
     
    </div>
</template>

<script setup>

</script>

<style scoped>
.main {
    height: calc(100vh - 130px); /* Subtract header and footer height */
    overflow-y: auto; /* Enable vertical scrolling if content exceeds viewport height */
}
</style>