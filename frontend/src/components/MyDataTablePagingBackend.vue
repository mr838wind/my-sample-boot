<template>

    <v-content>
      <v-container fluid grid-list-md >

        <v-layout row  justify-center   >
          <v-flex xs10   >
            <v-card class="info" >  
              <v-card-title>
                <h3 class="display-2 pa-3"  >hello data table. (paging backend) </h3>
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

    computed: {
      //== paging
      pagingParam() {
          console.log('pagination = %o', this.pagination);
          const { sortBy, descending, page, rowsPerPage } = this.pagination;
          return {
                size: rowsPerPage
                ,current: page
                ,orderByField: this.$_.snakeCase(sortBy)
                ,asc: !descending
          }
      }
    },

    watch: {
      //== paging
      pagingParam: {
        handler(newValue, oldValue) {
              // fix pagination triggered when totalItems change 
              if (JSON.stringify(newValue) == JSON.stringify(oldValue)) {
                return;
              }
              console.log('>> watching pagingParam !!');
              this.getDataFromApi(response => {
                  this.totalItems = response.data.total;  
                  this.myItems = response.data.records;
              });
        },
        deep: false
      }
    },

    mounted() {
      console.log('>> mounted!! ');
    },

    methods: {
        getDataFromApi(callbackSuccess) {
          console.log('>> getDataFromApi');

          this.$AjaxUtils.get(
            '/ajax/sample/paging', 
            { params: this.pagingParam }, 
            callbackSuccess,
            () => {this.loading = true}, 
            () => {this.loading = false}
          );
          
        }

    }

  }
</script>