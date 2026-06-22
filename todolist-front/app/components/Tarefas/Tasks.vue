<template>
  <div>
    <div class="mx-auto my-4 w-50">
      <table class="table align-middle table-hover">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Tarefas</th>
            <th scope="col">Status</th>
            <th scope="col">Ações</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(task, index) in tasks" :key="task.id || index">
            <th scope="row text-emphasis" >{{ index + 1 }}</th>
            <td class="w-100 text-emphasis" :class="{ 'text-decoration-line-through': task.completed != false }">{{ task.title }}</td>
            <td class="w-100"> 
              <span v-if="task.completed" class="badge bg-success text-emphasis">Concluída</span>
              <span v-else class="badge bg-warning text-dark text-emphasis">Pendente</span>
            </td>
            <td>
              <div class="btn-group" role="group" aria-label="Task Actions">
                <button @click="completeTask(task)" class="btn btn-outline-success btn-sm">
                  <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="0 0 24 24"><!-- Icon from Material Design Icons by Pictogrammers - https://github.com/Templarian/MaterialDesign/blob/master/LICENSE --><path fill="currentColor" d="M12 2C6.5 2 2 6.5 2 12s4.5 10 10 10s10-4.5 10-10S17.5 2 12 2m0 18c-4.41 0-8-3.59-8-8s3.59-8 8-8s8 3.59 8 8s-3.59 8-8 8m4.59-12.42L10 14.17l-2.59-2.58L6 13l4 4l8-8z"/></svg>
                </button>
                <button @click="removeTask(index)" class="btn btn-outline-info btn-sm" :class="{ 'disabled': task.description == null ? true : false }">
                  <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="0 0 24 24"><!-- Icon from Material Design Icons by Pictogrammers - https://github.com/Templarian/MaterialDesign/blob/master/LICENSE --><path fill="currentColor" d="M12 9a3 3 0 0 0-3 3a3 3 0 0 0 3 3a3 3 0 0 0 3-3a3 3 0 0 0-3-3m0 8a5 5 0 0 1-5-5a5 5 0 0 1 5-5a5 5 0 0 1 5 5a5 5 0 0 1-5 5m0-12.5C7 4.5 2.73 7.61 1 12c1.73 4.39 6 7.5 11 7.5s9.27-3.11 11-7.5c-1.73-4.39-6-7.5-11-7.5"/></svg>
                </button>
                <button @click="removeTask(task, index)" class="btn btn-outline-danger btn-sm">
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
import { ref, onMounted } from 'vue';

const newTask = ref('');
const tasks = ref([]);

const getTasks = async () => {
  try {
    const response = await fetch('http://localhost:8080/tasks/');

    if (!response.ok) {
      throw new Error('Network response was not ok');
    }

    const data = await response.json();
    console.log('Fetched tasks:', data);

    // const data = await response.json();
    tasks.value = data;
  } catch (error) {
    console.error('Error fetching tasks:', error);
  }
}



const completeTask = async (task) => {
  try {
    // Faz a chamada PATCH diretamente para a rota semântica do Spring Boot
    const response = await fetch(`http://localhost:8080/tasks/${task.id}/complete`, {
      method: 'PATCH'
    });

    if (response.ok) {
      const updatedTask = await response.json();
      
      // Atualiza o estado da tarefa localmente para refletir na tela imediatamente
      task.completed = true;
      task.updatedAt = updatedTask.updatedAt; // Guarda a nova data de atualização, se precisar exibir
      
      console.log(`Tarefa "${task.title}" concluída com sucesso!`);
    } else if (response.status === 404) {
      alert('Esta tarefa não foi encontrada no servidor.');
    } else {
      throw new Error('Erro ao concluir a tarefa');
    }
  } catch (error) {
    console.error('Error completing task:', error);
  }
}

const removeTask = async (task, index) => {
  if (!confirm(`Tem certeza que deseja remover a tarefa "${task.title}"?`)) return;
  try {
    const taskToRemove = tasks.value[index];
    const response = await fetch(`http://localhost:8080/tasks/${task.id}`, {
      method: 'DELETE'
    });

    if (response.status === 204) {
      tasks.value.splice(index, 1);
      console.log('Tarefa removida com sucesso!');
    } else if (response.status === 404) {
      alert('Essa tarefa não foi encontrada no servidor.');
    } else {
      throw new Error('Erro ao deletar tarefa');
    }
  } catch (error) {
    console.error('Error removing task:', error);
  }
}


onMounted(() => {
  getTasks();
});
</script>

<style>

</style>