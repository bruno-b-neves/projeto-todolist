<template>
  <NuxtPage />
</template>

<script setup>
definePageMeta({
  layout: 'dashboard',
  middleware: 'auth',
})
</script>

<style>

</style>