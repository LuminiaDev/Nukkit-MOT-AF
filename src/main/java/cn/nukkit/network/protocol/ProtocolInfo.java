package cn.nukkit.network.protocol;

import cn.nukkit.utils.Utils;
import com.google.common.primitives.Ints;

import java.util.List;

/**
 * @author MagicDroidX &amp; iNevet
 * Nukkit Project
 */
public interface ProtocolInfo {

    int v1_1_0 = 113;
    int v1_2_0 = 137;
    int v1_2_5_11 = 140;
    int v1_2_5 = 141;
    int v1_2_6 = 150;
    int v1_2_7 = 160;
    int v1_2_10 = 201;
    int v1_2_13 = 223;
    int v1_2_13_11 = 224;
    int v1_4_0 = 261;
    int v1_5_0 = 274;
    int v1_6_0_5 = 281;
    int v1_6_0 = 282;
    int v1_7_0 = 291;
    int v1_8_0 = 313;
    int v1_9_0 = 332;
    int v1_10_0 = 340;
    int v1_11_0 = 354;
    int v1_12_0 = 361;
    int v1_13_0 = 388;
    int v1_14_0 = 389;
    int v1_14_60 = 390;
    int v1_16_0 = 407;
    int v1_16_20 = 408;
    int v1_16_100_0 = 409;
    int v1_16_100_51 = 410;
    int v1_16_100_52 = 411;
    int v1_16_100 = 419;
    int v1_16_200_51 = 420;
    int v1_16_200 = 422;
    int v1_16_210_50 = 423;
    int v1_16_210_53 = 424;
    int v1_16_210 = 428;
    int v1_16_220 = 431;
    int v1_16_230_50 = 433;
    int v1_16_230 = 434;
    int v1_16_230_54 = 435;
    int v1_17_0 = 440;
    int v1_17_10 = 448;
    int v1_17_20_20 = 453;
    int v1_17_30 = 465;
    int v1_17_40 = 471;
    int v1_18_0 = 475;
    int v1_18_10_26 = 485;
    int v1_18_10 = 486;
    int v1_18_30 = 503;
    int v1_19_0_29 = 524;
    int v1_19_0_31 = 526;
    int v1_19_0 = 527;
    int v1_19_10 = 534;
    int v1_19_20 = 544;
    int v1_19_21 = 545;
    int v1_19_30_23 = 553;
    int v1_19_30 = 554;
    int v1_19_40 = 557;
    int v1_19_50_20 = 558;
    int v1_19_50 = 560;
    int v1_19_60 = 567;
    int v1_19_63 = 568;
    int v1_19_70_24 = 574;
    int v1_19_70 = 575;
    int v1_19_80 = 582;
    int v1_20_0_23 = 588;
    int v1_20_0 = 589;
    int v1_20_10_21 = 593;
    int v1_20_10 = 594;
    int v1_20_30_24 = 617;
    int v1_20_30 = 618;
    int v1_20_40 = 622;
    int v1_20_50 = 630;
    int v1_20_60 = 649;
    int v1_20_70 = 662;
    int v1_20_80 = 671;
    int v1_21_0 = 685;
    int v1_21_2 = 686;
    int v1_21_20 = 712;
    int v1_21_30 = 729;
    int v1_21_40 = 748;
    int v1_21_50_26 = 765;
    int v1_21_50 = 766;
    int v1_21_60 = 776;
    int v1_21_70_24 = 785; //TODO
    int v1_21_70 = 786;
    int v1_21_80 = 800;
    int v1_21_90 = 818;
    int v1_21_93 = 819;

    int CURRENT_PROTOCOL = Utils.dynamic(v1_21_93);

    List<Integer> SUPPORTED_PROTOCOLS = Ints.asList(
            /*v1_1_0, */v1_2_0, v1_2_5_11, v1_2_5, v1_2_6, v1_2_7, v1_2_10, v1_2_13, v1_2_13_11, v1_4_0, v1_5_0, v1_6_0_5, v1_6_0, v1_7_0,
            v1_8_0, v1_9_0, v1_10_0, v1_11_0, v1_12_0, v1_13_0, v1_14_0, v1_14_60, v1_16_0, v1_16_20, v1_16_100_0, v1_16_100_51,
            v1_16_100_52, v1_16_100, v1_16_200_51, v1_16_200, v1_16_210_50, v1_16_210_53, v1_16_210, v1_16_220, v1_16_230_50, v1_16_230,
            v1_16_230_54, v1_17_0, v1_17_10, v1_17_20_20, v1_17_30, v1_17_40, v1_18_0, v1_18_10, v1_18_30, v1_19_0_29, v1_19_0_31, v1_19_0,
            v1_19_10, v1_19_20, v1_19_21, v1_19_30_23, v1_19_30, v1_19_40, v1_19_50_20, v1_19_50, v1_19_60, v1_19_63, v1_19_70_24, v1_19_70,
            v1_19_80, v1_20_0_23, v1_20_0, v1_20_10_21, v1_20_10, v1_20_30_24, v1_20_30, v1_20_40, v1_20_50, v1_20_60, v1_20_70, v1_20_80,
            v1_21_0, v1_21_2, v1_21_20, v1_21_30, v1_21_40, v1_21_50_26, v1_21_50, v1_21_60, v1_21_70_24, v1_21_70, v1_21_80, v1_21_90,
            v1_21_93
    );

    String MINECRAFT_VERSION_NETWORK = Utils.getVersionByProtocol(CURRENT_PROTOCOL);
    String MINECRAFT_VERSION = 'v' + MINECRAFT_VERSION_NETWORK;

    byte BATCH_PACKET = (byte) 0xff;
    byte LOGIN_PACKET = 0x01;
    byte PLAY_STATUS_PACKET = 0x02;
    byte SERVER_TO_CLIENT_HANDSHAKE_PACKET = 0x03;
    byte CLIENT_TO_SERVER_HANDSHAKE_PACKET = 0x04;
    byte DISCONNECT_PACKET = 0x05;
    byte RESOURCE_PACKS_INFO_PACKET = 0x06;
    byte RESOURCE_PACK_STACK_PACKET = 0x07;
    byte RESOURCE_PACK_CLIENT_RESPONSE_PACKET = 0x08;
    byte TEXT_PACKET = 0x09;
    byte SERVER_POST_MOVE_POSITION = 0x10;
    byte SET_TIME_PACKET = 0x0a;
    byte START_GAME_PACKET = 0x0b;
    byte ADD_PLAYER_PACKET = 0x0c;
    byte ADD_ENTITY_PACKET = 0x0d;
    byte REMOVE_ENTITY_PACKET = 0x0e;
    byte ADD_ITEM_ENTITY_PACKET = 0x0f;
    byte TAKE_ITEM_ENTITY_PACKET = 0x11;
    byte MOVE_ENTITY_ABSOLUTE_PACKET = 0x12;
    byte MOVE_PLAYER_PACKET = 0x13;
    byte RIDER_JUMP_PACKET = 0x14;
    byte UPDATE_BLOCK_PACKET = 0x15;
    byte ADD_PAINTING_PACKET = 0x16;
    byte TICK_SYNC_PACKET = 0x17;
    byte LEVEL_SOUND_EVENT_PACKET_V1 = 0x18;
    byte LEVEL_EVENT_PACKET = 0x19;
    byte BLOCK_EVENT_PACKET = 0x1a;
    byte ENTITY_EVENT_PACKET = 0x1b;
    byte MOB_EFFECT_PACKET = 0x1c;
    byte UPDATE_ATTRIBUTES_PACKET = 0x1d;
    byte INVENTORY_TRANSACTION_PACKET = 0x1e;
    byte MOB_EQUIPMENT_PACKET = 0x1f;
    byte MOB_ARMOR_EQUIPMENT_PACKET = 0x20;
    byte INTERACT_PACKET = 0x21;
    byte BLOCK_PICK_REQUEST_PACKET = 0x22;
    byte ENTITY_PICK_REQUEST_PACKET = 0x23;
    byte PLAYER_ACTION_PACKET = 0x24;
    byte ENTITY_FALL_PACKET = 0x25;
    byte HURT_ARMOR_PACKET = 0x26;
    byte SET_ENTITY_DATA_PACKET = 0x27;
    byte SET_ENTITY_MOTION_PACKET = 0x28;
    byte SET_ENTITY_LINK_PACKET = 0x29;
    byte SET_HEALTH_PACKET = 0x2a;
    byte SET_SPAWN_POSITION_PACKET = 0x2b;
    byte ANIMATE_PACKET = 0x2c;
    byte RESPAWN_PACKET = 0x2d;
    byte CONTAINER_OPEN_PACKET = 0x2e;
    byte CONTAINER_CLOSE_PACKET = 0x2f;
    byte PLAYER_HOTBAR_PACKET = 0x30;
    byte INVENTORY_CONTENT_PACKET = 0x31;
    byte INVENTORY_SLOT_PACKET = 0x32;
    byte CONTAINER_SET_DATA_PACKET = 0x33;
    byte CRAFTING_DATA_PACKET = 0x34;
    byte CRAFTING_EVENT_PACKET = 0x35;
    byte GUI_DATA_PICK_ITEM_PACKET = 0x36;
    byte ADVENTURE_SETTINGS_PACKET = 0x37;
    byte BLOCK_ENTITY_DATA_PACKET = 0x38;
    byte PLAYER_INPUT_PACKET = 0x39;
    byte FULL_CHUNK_DATA_PACKET = 0x3a;
    byte SET_COMMANDS_ENABLED_PACKET = 0x3b;
    byte SET_DIFFICULTY_PACKET = 0x3c;
    byte CHANGE_DIMENSION_PACKET = 0x3d;
    byte SET_PLAYER_GAME_TYPE_PACKET = 0x3e;
    byte PLAYER_LIST_PACKET = 0x3f;
    byte SIMPLE_EVENT_PACKET = 0x40;
    byte EVENT_PACKET = 0x41;
    byte SPAWN_EXPERIENCE_ORB_PACKET = 0x42;
    byte CLIENTBOUND_MAP_ITEM_DATA_PACKET = 0x43;
    byte MAP_INFO_REQUEST_PACKET = 0x44;
    byte REQUEST_CHUNK_RADIUS_PACKET = 0x45;
    byte CHUNK_RADIUS_UPDATED_PACKET = 0x46;
    byte ITEM_FRAME_DROP_ITEM_PACKET = 0x47;
    byte GAME_RULES_CHANGED_PACKET = 0x48;
    byte CAMERA_PACKET = 0x49;
    byte BOSS_EVENT_PACKET = 0x4a;
    byte SHOW_CREDITS_PACKET = 0x4b;
    byte AVAILABLE_COMMANDS_PACKET = 0x4c;
    byte COMMAND_REQUEST_PACKET = 0x4d;
    byte COMMAND_BLOCK_UPDATE_PACKET = 0x4e;
    byte COMMAND_OUTPUT_PACKET = 0x4f;
    byte UPDATE_TRADE_PACKET = 0x50;
    byte UPDATE_EQUIPMENT_PACKET = 0x51;
    byte RESOURCE_PACK_DATA_INFO_PACKET = 0x52;
    byte RESOURCE_PACK_CHUNK_DATA_PACKET = 0x53;
    byte RESOURCE_PACK_CHUNK_REQUEST_PACKET = 0x54;
    byte TRANSFER_PACKET = 0x55;
    byte PLAY_SOUND_PACKET = 0x56;
    byte STOP_SOUND_PACKET = 0x57;
    byte SET_TITLE_PACKET = 0x58;
    byte ADD_BEHAVIOR_TREE_PACKET = 0x59;
    byte STRUCTURE_BLOCK_UPDATE_PACKET = 0x5a;
    byte SHOW_STORE_OFFER_PACKET = 0x5b;
    byte PURCHASE_RECEIPT_PACKET = 0x5c;
    byte PLAYER_SKIN_PACKET = 0x5d;
    byte SUB_CLIENT_LOGIN_PACKET = 0x5e;
    byte INITIATE_WEB_SOCKET_CONNECTION_PACKET = 0x5f;
    byte SET_LAST_HURT_BY_PACKET = 0x60;
    byte BOOK_EDIT_PACKET = 0x61;
    byte NPC_REQUEST_PACKET = 0x62;
    byte PHOTO_TRANSFER_PACKET = 0x63;
    byte MODAL_FORM_REQUEST_PACKET = 0x64;
    byte MODAL_FORM_RESPONSE_PACKET = 0x65;
    byte SERVER_SETTINGS_REQUEST_PACKET = 0x66;
    byte SERVER_SETTINGS_RESPONSE_PACKET = 0x67;
    byte SHOW_PROFILE_PACKET = 0x68;
    byte SET_DEFAULT_GAME_TYPE_PACKET = 0x69;
    byte REMOVE_OBJECTIVE_PACKET = 0x6a;
    byte SET_DISPLAY_OBJECTIVE_PACKET = 0x6b;
    byte SET_SCORE_PACKET = 0x6c;
    byte LAB_TABLE_PACKET = 0x6d;
    byte UPDATE_BLOCK_SYNCED_PACKET = 0x6e;
    byte MOVE_ENTITY_DELTA_PACKET = 0x6f;
    byte SET_SCOREBOARD_IDENTITY_PACKET = 0x70;
    byte SET_LOCAL_PLAYER_AS_INITIALIZED_PACKET = 0x71;
    byte UPDATE_SOFT_ENUM_PACKET = 0x72;
    byte NETWORK_STACK_LATENCY_PACKET = 0x73;
    byte SCRIPT_CUSTOM_EVENT_PACKET = 0x75;
    byte SPAWN_PARTICLE_EFFECT_PACKET = 0x76;
    byte AVAILABLE_ENTITY_IDENTIFIERS_PACKET = 0x77;
    byte LEVEL_SOUND_EVENT_PACKET_V2 = 0x78;
    byte NETWORK_CHUNK_PUBLISHER_UPDATE_PACKET = 0x79;
    byte BIOME_DEFINITION_LIST_PACKET = 0x7a;
    byte LEVEL_SOUND_EVENT_PACKET = 0x7b;
    byte LEVEL_EVENT_GENERIC_PACKET = 0x7c;
    byte LECTERN_UPDATE_PACKET = 0x7d;
    byte VIDEO_STREAM_CONNECT_PACKET = 0x7e;
    byte CLIENT_CACHE_STATUS_PACKET = (byte) 0x81;
    byte ON_SCREEN_TEXTURE_ANIMATION_PACKET = (byte) 0x82;
    byte MAP_CREATE_LOCKED_COPY_PACKET = (byte) 0x83;
    byte STRUCTURE_TEMPLATE_DATA_EXPORT_REQUEST = (byte) 0x84;
    byte STRUCTURE_TEMPLATE_DATA_EXPORT_RESPONSE = (byte) 0x85;
    byte UPDATE_BLOCK_PROPERTIES = (byte) 0x86;
    byte CLIENT_CACHE_BLOB_STATUS_PACKET = (byte) 0x87;
    byte CLIENT_CACHE_MISS_RESPONSE_PACKET = (byte) 0x88;
    byte EDUCATION_SETTINGS_PACKET = (byte) 0x89;
    byte EMOTE_PACKET = (byte) 0x8a;
    byte MULTIPLAYER_SETTINGS_PACKET = (byte) 0x8b;
    byte SETTINGS_COMMAND_PACKET = (byte) 0x8c;
    byte ANVIL_DAMAGE_PACKET = (byte) 0x8d;
    byte COMPLETED_USING_ITEM_PACKET = (byte) 0x8e;
    byte NETWORK_SETTINGS_PACKET = (byte) 0x8f;
    byte PLAYER_AUTH_INPUT_PACKET = (byte) 0x90;
    byte CREATIVE_CONTENT_PACKET = (byte) 0x91;
    byte PLAYER_ENCHANT_OPTIONS_PACKET = (byte) 0x92;
    byte ITEM_STACK_REQUEST_PACKET = (byte) 0x93;
    byte ITEM_STACK_RESPONSE_PACKET = (byte) 0x94;
    byte PLAYER_ARMOR_DAMAGE_PACKET = (byte) 0x95;
    byte CODE_BUILDER_PACKET = (byte) 0x96;
    byte UPDATE_PLAYER_GAME_TYPE_PACKET = (byte) 0x97;
    byte EMOTE_LIST_PACKET = (byte) 0x98;
    byte POS_TRACKING_SERVER_BROADCAST_PACKET = (byte) 0x99;
    byte POS_TRACKING_CLIENT_REQUEST_PACKET = (byte) 0x9a;
    byte DEBUG_INFO_PACKET = (byte) 0x9b;
    byte PACKET_VIOLATION_WARNING_PACKET = (byte) 0x9c;
    byte MOTION_PREDICTION_HINTS_PACKET = (byte) 0x9d;
    byte ANIMATE_ENTITY_PACKET = (byte) 0x9e;
    byte CAMERA_SHAKE_PACKET = (byte) 0x9f;
    byte PLAYER_FOG_PACKET = (byte) 0xa0;
    byte CORRECT_PLAYER_MOVE_PREDICTION_PACKET = (byte) 0xa1;
    byte ITEM_COMPONENT_PACKET = (byte) 0xa2;
    byte FILTER_TEXT_PACKET = (byte) 0xa3;
    byte CLIENTBOUND_DEBUG_RENDERER_PACKET = (byte) 0xa4;
    byte SYNC_ENTITY_PROPERTY_PACKET = (byte) 0xa5;
    byte ADD_VOLUME_ENTITY_PACKET = (byte) 0xa6;
    byte REMOVE_VOLUME_ENTITY_PACKET = (byte) 0xa7;
    byte SIMULATION_TYPE_PACKET = (byte) 0xa8;
    byte NPC_DIALOGUE_PACKET = (byte) 0xa9;
    byte EDU_URI_RESOURCE_PACKET = (byte) 0xaa;
    byte CREATE_PHOTO_PACKET = (byte) 0xab;
    byte UPDATE_SUB_CHUNK_BLOCKS_PACKET = (byte) 0xac;
    byte PHOTO_INFO_REQUEST_PACKET = (byte) 0xad;
    byte SUB_CHUNK_PACKET = (byte) 0xae;
    byte SUB_CHUNK_REQUEST_PACKET = (byte) 0xaf;
    byte PLAYER_START_ITEM_COOLDOWN_PACKET = (byte) 0xb0;
    byte SCRIPT_MESSAGE_PACKET = (byte) 0xb1;
    byte CODE_BUILDER_SOURCE_PACKET = (byte) 0xb2;
    byte TICKING_AREAS_LOAD_STATUS_PACKET = (byte) 0xb3;
    byte DIMENSION_DATA_PACKET = (byte) 0xb4;
    byte AGENT_ACTION_EVENT_PACKET = (byte) 0xb5;
    byte CHANGE_MOB_PROPERTY_PACKET = (byte) 0xb6;
    byte LESSON_PROGRESS_PACKET = (byte) 0xb7;
    byte REQUEST_ABILITY_PACKET = (byte) 0xb8;
    byte REQUEST_PERMISSIONS_PACKET = (byte) 0xb9;
    byte TOAST_REQUEST_PACKET = (byte) 0xba;
    byte UPDATE_ABILITIES_PACKET = (byte) 0xbb;
    byte UPDATE_ADVENTURE_SETTINGS_PACKET = (byte) 0xbc;
    byte DEATH_INFO_PACKET = (byte) 0xbd;
    byte REQUEST_NETWORK_SETTINGS_PACKET = (byte) 0xc1;
    byte GAME_TEST_RESULTS_PACKET = (byte) 0xc3;
    byte UPDATE_CLIENT_INPUT_LOCKS = (byte) 0xc4;
    byte CLIENT_CHEAT_ABILITY_PACKET = (byte) 0xc5;
    byte CAMERA_PRESETS_PACKET = (byte) 0xc6;
    byte UNLOCKED_RECIPES_PACKET = (byte) 0xc7;

    int CAMERA_INSTRUCTION_PACKET = 300;
    int COMPRESSED_BIOME_DEFINITIONS_LIST_PACKET = 301;
    int TRIM_DATA_PACKET = 302;
    int OPEN_SIGN_PACKET = 303;
    int AGENT_ANIMATION_PACKET = 304;
    int REFRESH_ENTITLEMENTS_PACKET = 305;
    int TOGGLE_CRAFTER_SLOT_REQUEST_PACKET = 306;
    int SET_PLAYER_INVENTORY_OPTIONS_PACKET = 307;
    int SET_HUD_PACKET = 308;
    int AWARD_ACHIEVEMENT_PACKET = 309;
    /**
     * @since v686
     */
    int CLIENTBOUND_CLOSE_FORM_PACKET = 310;
    /**
     * @since v712
     */
    int SERVERBOUND_LOADING_SCREEN_PACKET = 312;
    /**
     * @since v712
     */
    int JIGSAW_STRUCTURE_DATA_PACKET = 313;
    /**
     * @since v712
     */
    int CURRENT_STRUCTURE_FEATURE_PACKET = 314;
    /**
     * @since v712
     */
    int SERVERBOUND_DIAGNOSTICS_PACKET = 315;
    /**
     * @since v729
     */
    int CAMERA_AIM_ASSIST_PACKET = 316;
    /**
     * @since v729
     */
    int CONTAINER_REGISTRY_CLEANUP_PACKET = 317;
    /**
     * @since v748
     */
    int MOVEMENT_EFFECT_PACKET = 318;
    /**
     * @since v748
     */
    int SET_MOVEMENT_AUTHORITY_PACKET = 319;
    /**
     * @since v766
     */
    int CAMERA_AIM_ASSIST_PRESETS_PACKET = 320;
    /**
     * @since v800
     */
    int PLAYER_LOCATIONS_PACKET = 326;

    static int toNewProtocolID(byte oldProtocolID) {
        return oldProtocolID & 0xff;
    }
}
