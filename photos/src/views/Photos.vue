<template>
    <v-container>
        <v-row>
            <v-col cols="12" class="mx-auto">
<!--              <div v-for="(photo, index) in photos" :key="index">-->
<!--                  <img :src="photo.url"/>-->
<!--                  <p>{{photo.message}}</p>-->
<!--                  <v-btn @click="deletePhoto(photo.id)">Delete</v-btn>-->
<!--              </div>-->
                <div>
                    <div class="float-right layoutBtns">
                        <v-btn @click="grid = true" :depressed="grid" :class="{ active: grid }" elevation="1"><v-icon>mdi-grid</v-icon></v-btn>
                        <v-btn class="ml-2" @click="grid = false" :depressed="!grid" :class="{ active: !grid }" elevation="1"><v-icon>mdi-format-list-checkbox</v-icon></v-btn>
                    </div>
                    <v-card
                        class="ma-1"
                        :class="[grid ? 'd-inline-block' : 'd-block']"
                        width="300"
                        v-for="(photo, index) in photos" :key="index"
                    >
                        <v-img
                            class="white--text align-end clickable"
                            height="200px"
                            :src="photo.url"
                            @click="goToRoute(photo.id)"
                        />
                        <v-card-text class="text--primary d-flex justify-space-between align-center">
                            <div class="truncate">{{photo.message}}</div>
                            <v-icon class="clickable">mdi-heart</v-icon>
                        </v-card-text>
                    </v-card>
                </div>
            </v-col>
        </v-row>
        <Snackbar :snackbar="snackbar"/>
    </v-container>
</template>

<script>
    import axios from 'axios';
    import { getSnackbar} from "@/helpers/helpers";
    import Snackbar from "@/components/Snackbar";
    const { VUE_APP_BASE_API } = process.env;

    export default {
        name: 'Photos',

        components: {
            Snackbar
        },

        data: () => ({
            photos: [],
            snackbar: {},
            grid: true,
        }),

        created() {
            this.getPhotos()
        },

        methods: {
            async getPhotos() {
                const {data} = await axios.get(`${VUE_APP_BASE_API}/api/v1/photos`)
                this.photos = data;
            },
            async deletePhoto(id) {
                try {
                    await axios.delete(`${VUE_APP_BASE_API}/api/v1/photos/${id}`)
                    this.photos = this.photos.filter(p => {
                        return p.id !== id
                    })
                    this.snackbar = getSnackbar('SUCCESS', 'Successfully deleted the image.')
                } catch(e) {
                    this.snackbar = getSnackbar('ERROR', 'Something went wrong, please try again...')
                }
            },
            goToRoute(id) {
                this.$router.push({ name: 'photo', params: { id: id }})
            }
        }
    };
</script>

<style lang="scss" scoped>
    @import "../styles/variables.scss";
    .truncate {
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        min-height: 10px;
    }
    .layoutBtns {
        width: fit-content;
    }
    .active {
        background-color: $color3 !important;
    }
</style>