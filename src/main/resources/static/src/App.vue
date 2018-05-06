<template>
  <v-app id="inspire">

    <!-- drawer -->
    <v-navigation-drawer
      fixed
      v-model="drawer"
      app
    >
      <v-list dense>
        <v-list-tile @click="">
          <v-list-tile-action>
            <v-icon>home</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>Home</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
        <v-list-tile @click="">
          <v-list-tile-action>
            <v-icon>contact_mail</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>Contact</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>
    
    <!-- top -->
    <v-toolbar color="indigo" dark fixed app>
      <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
      <v-toolbar-title>Application</v-toolbar-title>
    </v-toolbar>

    <!-- content -->
    <my-content></my-content>

    <!-- footer -->
    <v-footer color="indigo" app>
      <span class="white--text"> &copy; 2018 wind >> v0.1</span>
    </v-footer>
  </v-app>
</template>

<script>
  import MyContent from './components/MyContent.vue'

  export default {
    components: {
      MyContent
    },
    data: () => ({
      drawer: false
    }),
    props: {
      source: String
    }
  }
</script>