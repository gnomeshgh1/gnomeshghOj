//initial state;
import { StoreOptions } from "vuex";

export default {
  namespaced: true,
  state: () => ({
    loginUser: {
      userName: "未登录",
      role: "customer",
    },
  }),
  actions: {
    getLoginUser({ commit, state }, payload) {
      //todo  远程调用获取登录信息
      commit("updateUser", { userName: "王一" });
    },
  },
  mutations: {
    updateUser(state, payload) {
      state.loginUser = payload;
    },
  },
} as StoreOptions<any>;
