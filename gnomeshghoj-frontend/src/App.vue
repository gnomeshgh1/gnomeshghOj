<template>
  <div id="app">
    <BasicLayout />
  </div>
</template>

<style>
#app {
}
</style>
<script setup lang="ts">
import BasicLayout from "@/layouts/BasicLayout";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
import { onMounted } from "vue";

/**
 * 全局初始化函数，有全局单次调用的代码，都可以写在这里
 */
const doInit = () => {
  console.log("hello...");
};
onMounted(() => {
  doInit();
});
const router = useRouter();
const store = useStore();
router.beforeEach((to, from, next) => {
  //仅管理员可见
  if (to.meta?.access === "admin") {
    if (store.state.user.loginUser?.userRole !== "admin") {
      next("/noAuth");
      return;
    }
  }
  next();
});
</script>
