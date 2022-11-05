<script setup lang="ts">
import type { LoginForm } from "@/types/LoginForm";

const form: LoginForm = {
  username: "",
  password: "",
};

function onSubmit() {
  console.log(form.username);
}
</script>

<template>
  <div id="login-view">
    <div class="vh-100 d-flex justify-content-center align-items-center">
      <div class="container">
        <div class="row d-flex justify-content-center">
          <div class="col-12 col-md-8 col-lg-6">
            <div class="border border-3 border-primary"></div>
            <div class="card bg-white shadow-lg">
              <div class="card-body p-5">
                <form
                  novalidate
                  @submit.prevent="onSubmit()"
                  class="mb-3 mt-md-4"
                >
                  <h2 class="fw-bold mb-2 text-uppercase">Brand</h2>
                  <p class="mb-5">Please enter your login and password!</p>
                  <div class="mb-3">
                    <label for="email" class="form-label">Username</label>
                    <input
                      v-model="form.username"
                      type="email"
                      class="form-control"
                      id="email"
                      placeholder="username"
                    />
                  </div>
                  <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input
                      v-model="form.username"
                      type="password"
                      class="form-control"
                      id="password"
                      placeholder="*******"
                    />
                  </div>
                  <p class="small">
                    <a class="text-primary" href="#">Forgot password?</a>
                  </p>
                  <div class="d-grid">
                    <button class="btn btn-outline-dark" type="submit">
                      Login
                    </button>
                  </div>
                </form>
                <div>
                  <p class="mb-0 text-center">
                    Don't have an account?
                    <a href="#" class="text-primary fw-bold">Sign Up</a>
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
