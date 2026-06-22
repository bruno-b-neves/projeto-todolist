<template>
    <div>
        <main class="main">
            <slot></slot>
        </main>     
    </div>
</template>

<script setup>

</script>

<style scoped>
.main {
    height: calc(100vh - 60px); /* Subtract header and footer height */
}
</style>