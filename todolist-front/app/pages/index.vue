<template>
  <div>
    <h1 class="lead display-3 fw-light text-center text-primary text-white-emphasis">Minhas Tarefas</h1>
    <div class="d-flex justify-content-center">
      <div class="input-group w-50">
        <input type="text" v-model="newTask" @keyup.enter="addTask" placeholder="Add a new task" class="form-control">
        <button @click="addTask" class="btn btn-outline-secondary">Registrar</button>
      </div>
    </div>
    <div class="mx-auto my-4 w-50">
      <table class="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col" colspan="2">Tarefas</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(task, index) in tasks" :key="index">
            <th scope="row">{{ index + 1 }}</th>
            <td colspan="2">{{ task }}</td>
            <td>
              <div class="btn-group" role="group" aria-label="Task Actions">
                <button @click="removeTask(index)" class="btn btn-outline-success btn-sm">
                  <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="0 0 24 24"><!-- Icon from Material Design Icons by Pictogrammers - https://github.com/Templarian/MaterialDesign/blob/master/LICENSE --><path fill="currentColor" d="M12 2C6.5 2 2 6.5 2 12s4.5 10 10 10s10-4.5 10-10S17.5 2 12 2m0 18c-4.41 0-8-3.59-8-8s3.59-8 8-8s8 3.59 8 8s-3.59 8-8 8m4.59-12.42L10 14.17l-2.59-2.58L6 13l4 4l8-8z"/></svg>
                </button>
                <button @click="removeTask(index)" class="btn btn-outline-warning btn-sm">
                  <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="0 0 24 24"><!-- Icon from Material Design Icons by Pictogrammers - https://github.com/Templarian/MaterialDesign/blob/master/LICENSE --><path fill="currentColor" d="M16.84 2.73c-.39 0-.77.15-1.07.44l-2.12 2.12l5.3 5.31l2.12-2.1c.6-.61.6-1.56 0-2.14L17.9 3.17c-.3-.29-.68-.44-1.06-.44M12.94 6l-8.1 8.11l2.56.28l.18 2.29l2.28.17l.29 2.56l8.1-8.11m-14 3.74L2.5 21.73l6.7-1.79l-.24-2.16l-2.31-.17l-.18-2.32"/></svg>
                </button>
                <button @click="removeTask(index)" class="btn btn-outline-danger btn-sm">
                  <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="0 0 24 24"><!-- Icon from Material Design Icons by Pictogrammers - https://github.com/Templarian/MaterialDesign/blob/master/LICENSE --><path fill="currentColor" d="M6 19a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V7H6zM8 9h8v10H8zm7.5-5l-1-1h-5l-1 1H5v2h14V4z"/></svg>
                </button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const newTask = ref('');

const tasks = ref([]);

const addTask = () => {
  if (newTask.value.trim() !== '') {
    tasks.value.push(newTask.value.trim());
    newTask.value = '';
  }
};

const removeTask = (index) => {
  tasks.value.splice(index, 1);
};
</script>

<style>

</style>