import { defineStore } from "pinia";
import { ref } from "vue";

export const useAuthStore = defineStore("authentication", () => {
  const user = ref({
    username: "",
  });

  return { user };
});
