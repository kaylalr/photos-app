<template>
    <v-container>
        <v-row>
            <v-col cols="12">
                <div class="d-flex flex-wrap ma-auto content">
                    <img :src="photo.url" class="image">
                    <p class="mx-6 my-3">{{photo.message}}</p>
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
        name: 'Photo',

        components: {
            Snackbar
        },

        data () {
            return {
                photo: [],
                snackbar: {},
                photoId: this.$route.params.id,
            }
        },

        created() {
            console.log(this.$route.params)
            this.getPhoto()
        },

        methods: {
            async getPhoto() {
                const {data} = await axios.get(`${VUE_APP_BASE_API}/api/v1/photos/${this.photoId}`)
                this.photo = data;
                console.log(this.photo)
            },
        }
    };
</script>

<style lang="scss" scoped>
    .image {
        /*max-height: 90vh;*/
        max-width: 100%;
    }
    .content {
        width: fit-content;
        max-width: 90%;
    }
    .content p {
        min-width: 200px;
        max-width: 500px;
    }

</style>