<template>

    <v-content>
      <v-container fluid grid-list-md >

        <v-layout row  justify-center   >
          <v-flex xs10   >
            <v-card class="info" >  
              <v-card-title>
                <h3 class="display-2 pa-3"  >hello data table. (paging frontend) </h3>
              </v-card-title>
            </v-card>
          </v-flex>
        </v-layout>  

        <!-- data table -->
        <v-layout row  justify-center   >
          <v-flex xs10   >
              <v-data-table
                :headers="headers"
                :items="myItems"
                :loading="loading"
                class="elevation-1"
              >
              
                <template slot="items" slot-scope="props">
                  <td>{{ props.item.id }}</td>
                  <td class="text-xs-left">{{ props.item.name }}</td>
                  <td class="text-xs-right">{{ props.item.contentsCount }}</td>
                </template>

                <template slot="no-data">
                  <v-alert :value="true" color="info" icon="warning">
                    Sorry, nothing to display here !!
                  </v-alert> 
                </template>
              </v-data-table>
          </v-flex>
        </v-layout>

      </v-container>
    </v-content> 

</template>

<script>
  export default {
    
    data() {
        return {
          loading: true,
          headers: [
            {
              text: 'Id',
              align: 'left',
              sortable: true,
              value: 'id'
            },
            { text: 'Name', value: 'name' },
            { text: 'ContentsCount', value: 'contentsCount' } 
          ],
          myItems: [ 
          ]
        }
    },

    mounted() {
      console.log('>> mounted!! ');
      this.getDataFromApi();
    },

    methods: {
        getDataFromApi() {
          console.log('>> getDataFromApi');
          
          this.$AjaxUtils.get(
            '/ajax/sample/list', 
            {  }, 
            response => {this.myItems = response.data;},
            () => {this.loading = true}, 
            () => {this.loading = false}
          );

        }
    }

  }
</script>