<template>
  <div class="home">
    <v-card flat :tile="true">
      <v-app-bar dense tabs class="elevation-1">
        <v-tabs color="red" slider-color="purple">
          <v-tab v-for="(tab, index) in tabs" :key="index"
                 :to="tab.path" class="py-2" >
            {{tab.label}}
          </v-tab>
        </v-tabs>
      </v-app-bar>
    </v-card>
    <router-view></router-view>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'home',
  components: {
  },
  data () {
    return {
      tabs: [
        {
          label: 'Photos',
          path: '/photos',
        },
        {
          label: 'Upload',
          path: '/uploadImg',
        },
      ]
    }
  }
}
</script>
