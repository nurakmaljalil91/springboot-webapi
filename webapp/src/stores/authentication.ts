import { defineStore } from "pinia";
import { ref } from "vue";
import axios from "axios";
import type { LoginResponse } from "@/types/LoginResponse";
import type { LoginForm } from "@/types/LoginForm";

export const useAuthStore = defineStore("authentication", () => {
  const user = ref(null);
  function login(loginForm: LoginForm) {
    const formData = new FormData();
    formData.set("username", loginForm.username);
    formData.set("password", loginForm.password);
    axios
      .post<LoginResponse>("http://localhost:8080/api/v1/login", formData, {
        headers: {
          Accept: "application/x-www-form-urlencoded",
        },
      })
      .then(function (response) {
        console.log(response);
      });
  }

  return { user, login };
});
