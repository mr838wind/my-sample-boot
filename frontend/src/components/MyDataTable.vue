<template>

    <v-content>
      <v-container fluid grid-list-md >

        <v-layout row  justify-center   >
          <v-flex xs10   >
            <v-card class="info" >  
              <v-card-title>
                <h3 class="display-2 pa-3"  >hello data table. (server side paging.) </h3>
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
                :pagination.sync="pagination"
                :total-items="totalItems"
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
          totalItems: 0,
          loading: true,
          pagination: {},
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

    watch: {
      pagination: {
        handler (val,oldVal) {
          this.getDataFromApi();
        },
        deep: true 
      }
    },
    

    mounted() {
      console.log('>> mounted!! ');
      this.getDataFromApi();
    },

    methods: {
        getDataFromApi() {
          console.log('>> getDataFromApi');
          console.log('pagination = %o', this.pagination);
          const { sortBy, descending, page, rowsPerPage } = this.pagination;
          
          this.loading = true; 

          this.$axios.get('/ajax/sample/paging', {
              params:{
                size: rowsPerPage
                ,current: page
                ,orderByField: this.$_.snakeCase(sortBy)
                ,asc: !descending
              }
          })
          .then(response => {
              this.loading = false;
              console.log('>>> %o', response);

              this.myItems = response.data.records;
              this.totalItems = response.data.total;  
          })
          .catch(e => {
              this.loading = false;
              console.log(e);
          })
        }
    }

  }
</script>