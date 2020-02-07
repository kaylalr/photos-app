<template>
  <v-app id="app">
    <router-view/>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  components: {
  },

  data: () => ({
    model: '',
  }),

  created() {
  },

  methods: {
  }
};
</script>

<style lang="scss">
  .container {
    max-width: unset !important;
  }
  .clickable {
    cursor: pointer;
  }
</style>