<template>
    <div>
        <main class="main">
            <slot></slot>
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
    height: calc(100vh - 60px); /* Subtract header and footer height */
    overflow-y: auto; /* Enable vertical scrolling if content exceeds viewport height */
}
</style>