<template>
  <div>
    <h1 class="lead display-3 fw-light text-center text-primary text-white-emphasis">Minhas Tarefas</h1>
    <div class="d-flex justify-content-center">
      <div class="input-group w-50">
        <input type="text" v-model="newTask" @keyup.enter="addTask" placeholder="Add a new task" class="form-control">
        <button @click="addTask" class="btn btn-outline-secondary">Registrar</button>
      </div>
    </div>
  </div>
</template>

<script setup>
const addTask = async () => {
  if (!newTask.value.trim()) return;

 try {
  const response = await fetch('http://localhost:8080/tasks/', { 
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ title: newTask.value.trim(), completed: false })
  });

  if (!response.ok) {
    const errorText = await response.text();
    throw new Error(`Network response was not ok: ${errorText}`);
  }

  const addedTask = await response.json();
  tasks.value.push(addedTask);
 } catch (error) {
    console.error('Error adding task:', error);
  }
};
</script>

<style>

</style>