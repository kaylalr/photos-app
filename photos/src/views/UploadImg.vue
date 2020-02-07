<template>
    <v-container>
        <v-row>
            <v-col cols="12">
                <v-form
                        ref="form"
                >
                    <v-file-input label="File input" v-model="photo.file"/>

                    <v-text-field
                            v-model="photo.url"
                            label="URL"
                            required
                    ></v-text-field>

                    <v-textarea
                            solo
                            v-model="photo.message"
                            name="message"
                            label="Message"
                            required
                    ></v-textarea>

                    <v-btn
                            color="success"
                            class="mr-4"
                            @click="uploadPhoto"
                    >
                        Upload
                    </v-btn>
                </v-form>
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
        name: 'uploadImg',

        components: {
            Snackbar,
        },

        data: () => ({
            photo: {},
            snackbar: {},
        }),

        methods: {
            async uploadPhoto() {
                try {
                    this.photo.filename = this.photo.file.name
                    await axios.post(`${VUE_APP_BASE_API}/api/v1/photos`, this.photo)
                    this.snackbar = getSnackbar('SUCCESS', 'Successfully uploaded the image!')
                } catch(e) {
                    this.snackbar = getSnackbar('ERROR', 'Something went wrong, please try again...')
                }
            }
        }
    };
</script>

<style lang="scss" scoped>

</style>