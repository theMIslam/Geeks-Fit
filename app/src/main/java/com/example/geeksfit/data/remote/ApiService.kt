package com.example.geeksfit.data.remote

import com.example.geeksfit.data.remote.model.*
import com.example.geeksfit.data.remote.model.card.CardBody
import com.example.geeksfit.data.remote.model.card.MyCard
import com.example.geeksfit.data.remote.model.fovoritetraining.FavoriteTraining
import com.example.geeksfit.data.remote.model.fovoritetraining.Training
import com.example.geeksfit.data.remote.model.login.RegistrationBody
import com.example.geeksfit.data.remote.model.personalinform.PersonalInform
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("/geeksfit/favoritetrainings/")
    fun getFavoriteTrainings(): retrofit2.Response<FavoriteTraining>

    @GET("/geeksfit/favoritetrainings/{id}/")
    fun getFavoriteTrainingsId(
        @Path("id") id: Int
    ): retrofit2.Response<FavoriteTraining>

    @GET("/geeksfit/trainings/{id}/")
    fun getTrainingsId(
        @Path("id") id: Int
    ): retrofit2.Response<Training>

    @GET("/geeksfit/trainings/")
    fun getTrainings(
        @Query("page") page: Int
    ): retrofit2.Response<Training>

    @GET("/personal_area/my_card/")
    fun getMyCard(): retrofit2.Response<MyCard>

    @POST("/personal_area/my_card/")
    fun postMyCard(
        @Body myCard: MyCard
    ): retrofit2.Response<MyCard>

    @GET("/personal_area/my_card/{id}/")
    fun getMyCardId(
        @Path("id") id: Int
    ): retrofit2.Response<MyCard>

    @PUT("/personal_area/my_card/{id}/")
    fun putMyCardId(
        @Body myCard: MyCard
    ): retrofit2.Response<MyCard>

    @PATCH("/personal_area/my_card/{id}/")
    fun patchMyCardId(
        @Body myCard: MyCard
    ): retrofit2.Response<MyCard>

    @GET("/personal_area/personal_inform_edit/{id}/")
    fun getPersonalInform(): Response<PersonalInform>

    @PUT("/personal_area/personal_inform_edit/{id}/")
    fun putPersonalInform(
        @Body personal: PersonalInform
    ): Response<PersonalInform>

    @PATCH("/personal_area/personal_inform_edit/{id}/")
    fun patchPersonalInform(
        @Body personal: PersonalInform
    ): retrofit2.Response<PersonalInform>

    @GET("/personal_area/personal_inform_view/")
    fun getPersonalInformView(): Call<PersonalInform>


    @POST("/personal_area/personal_inform_view/")
    fun postPersonalInformView(
        @Body personal: PersonalInform
    ): retrofit2.Response<PersonalInform>

    @GET("/personal_area/profile_email/")
    fun getUser(
        @Body personal: PersonalInform
    ): retrofit2.Response<PersonalInform>

    @PUT("/personal_area/profile_email/")
    fun putUser(
        @Body personal: PersonalInform
    ): retrofit2.Response<PersonalInform>

    @PATCH("/personal_area/profile_email/")
    fun patchUser(
        @Body personal: PersonalInform
    ): retrofit2.Response<PersonalInform>


}