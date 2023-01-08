<script lang="ts" context="module">
    export default interface PasswordEvent {
        password: string
    }
</script>
<script lang="ts">
    import {Icon} from "svelte-awesome";
    import {key} from "svelte-awesome/icons";
    import {getPassword} from "../lib/client";
    import {createEventDispatcher} from "svelte";

    const dispatch = createEventDispatcher();
    let password = "";

    const generate = async() => {
        const data = await getPassword();
        password = data.password;

        dispatch("password", {
            password: password,
        });
    };
</script>

<div>
    <input type="text" bind:value={password} readonly class="border border-gray-500 rounded-lg text-lg py-1 bg-gray-900 px-2" size="50">
    <button on:click={generate} class="rounded-lg text-lg bg-blue-700 hover:bg-blue-800 px-4 py-1">
        <Icon data={key} />
        Generate
    </button>
</div>