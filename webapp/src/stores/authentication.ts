import { defineStore } from "pinia";
import { reactive } from "vue";
import { useRouter } from 'vue-router'
import axios from "axios";
import type { LoginResponse } from "@/types/LoginResponse";
import type { LoginForm } from "@/types/LoginForm";

export const useAuthStore = defineStore("authentication", () => {
  const router = useRouter();
  let user = reactive<LoginResponse>({
    username: "",
    roles: [],
    accessToken: "",
    refreshToken: "",
  });
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
        user = response.data;
        sessionStorage.setItem("user", JSON.stringify(user));
        router.push("/");
      });
  }

  return { user, login };
});
