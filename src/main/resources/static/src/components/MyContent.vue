<template>

    <v-content>
      <v-container fluid fill-height>
        <v-layout row  wrap >
          <v-flex xs10 offset-xs1>
            <v-card dark color="purple">
              <v-card-text>xs10 offset-xs1</v-card-text>
            </v-card>
          </v-flex>
          
          <!--  -->
          <v-flex xs12>
            <v-alert type="success" :value="true">
              This is a success alert. 
            </v-alert>
          </v-flex>
         

        </v-layout>
      </v-container>
    </v-content>

</template>

<script>
  export default {
    data: () => ({
    }),
    props: {
    }
  }
</script>