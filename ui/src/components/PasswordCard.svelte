<script lang="ts">
    import { Icon } from "svelte-awesome";
    import { eye, eyeSlash } from "svelte-awesome/icons";

    export let password = "";
    let showPassword = false;

    const toggleVisibility = async () => {
        console.log("toggle");
        showPassword = !showPassword;
    };
</script>

<div class="p-4 border-2 border-gray-700 rounded-lg my-2">
    <p class="text-lg font-bold">Password</p>
    <div class="pt-2">
        {#if showPassword}
            <button on:click={toggleVisibility} class="hover:text-amber-700">
                <Icon data={eyeSlash} class="pb-1" scale={1.3} />
            </button>
            <span>{password}</span>
        {:else}
            <button on:click={toggleVisibility} class="hover:text-amber-700">
                <Icon data={eye} class="pb-1" scale={1.3} />
            </button>
            <span>****************</span>
        {/if}
    </div>
</div>
