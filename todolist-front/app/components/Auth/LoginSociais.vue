<template>
    <div class="mb-5 border-bottom w-100">
        <div class="d-flex gap-3 py-4 align-items-center justify-content-center rounded-circle">
            <button class="btn btn-outline-secondary btn-box rounded-circle">
                <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 640 640"><!-- Icon from Font Awesome Brands by Dave Gandy - https://creativecommons.org/licenses/by/4.0/ --><path fill="currentColor" d="M564 325.8C564 467.3 467.1 568 324 568C186.8 568 76 457.2 76 320S186.8 72 324 72c66.8 0 123 24.5 166.3 64.9l-67.5 64.9c-88.3-85.2-252.5-21.2-252.5 118.2c0 86.5 69.1 156.6 153.7 156.6c98.2 0 135-70.4 140.8-106.9H324v-85.3h236.1c2.3 12.7 3.9 24.9 3.9 41.4"/></svg>
            </button>
            <button class="btn btn-outline-secondary btn-box rounded-circle">
                <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 640 640"><!-- Icon from Font Awesome Brands by Dave Gandy - https://creativecommons.org/licenses/by/4.0/ --><path fill="currentColor" d="M332 70.5c-102.6 0-204 68.4-204 179.1C128 320 167.6 360 191.6 360c9.9 0 15.6-27.6 15.6-35.4c0-9.3-23.7-29.1-23.7-67.8c0-80.4 61.2-137.4 140.4-137.4c68.1 0 118.5 38.7 118.5 109.8c0 53.1-21.3 152.7-90.3 152.7c-24.9 0-46.2-18-46.2-43.8c0-37.8 26.4-74.4 26.4-113.4c0-66.2-93.9-54.2-93.9 25.8c0 16.8 2.1 35.4 9.6 50.7c-13.8 59.4-42 147.9-42 209.1c0 18.9 2.7 37.5 4.5 56.4c3.4 3.8 1.7 3.4 6.9 1.5c50.4-69 48.6-82.5 71.4-172.8c12.3 23.4 44.1 36 69.3 36c106.2 0 153.9-103.5 153.9-196.8c0-99.3-85.8-164.1-180-164.1"/></svg>
            </button>
            <button class="btn btn-outline-secondary btn-box rounded-circle">
                <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 640 640"><!-- Icon from Font Awesome Brands by Dave Gandy - https://creativecommons.org/licenses/by/4.0/ --><path fill="currentColor" d="M453.2 112h70.6L369.6 288.2L551 528H409L297.7 382.6L170.5 528H99.8l164.9-188.5L90.8 112h145.6l100.5 132.9zm-24.8 373.8h39.1L215.1 152h-42z"/></svg>
            </button>
        </div>
    </div>
</template>

<script setup>
    import { ref } from 'vue';

    const authStore = useAuthStore();
    
</script>

<style lang="scss" scoped>
    .btn-box {
        width: 42px;
        height: 42px;
        display: flex;
        align-items: center;
        justify-content: center;
    }
</style>